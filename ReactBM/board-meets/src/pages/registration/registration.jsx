import { useNavigate } from "react-router-dom";
import style from "./registration.module.css";
import { useForm } from "react-hook-form";
import axios from "axios";
import { RegistrationFirstStep } from "../../components/registration/registrationFirstStep/registrationFirstStep";
import { useState } from "react";
import { RegistrationSecondStep } from "../../components/registration/registrationSecondStep copy/registrationSecondStep";

export const Registration = ({ url, buttonHandler }) => {
  const {
    register,
    watch,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const [regStep, setRegStep] = useState("firstStep");

  const firstStepHandler = () => {
    setRegStep("secondStep");
  };
  const secondStepHandler = () => {
    setRegStep("firstStep");
  };

  const navigate = useNavigate();

  const onSubmit = (data) => {
    const body = {
      email: data.email,
      username: data.nickname,
      name: data.name + " " + data.surname,
      roles:
        data.role === "player"
          ? [{ id: 2 }]
          : data.role === "publisher"
          ? [{ id: 3 }]
          : [{ id: 4 }],
      city: data.city,
      aboutMe: data.aboutMe,
      password: data.password,
    };

    axios.post(url + `users/register`, body).then(() => {
      let body = {
        username: data.nickname,
        password: data.password,
      };
      axios
        .post(url + "auth/login", body, { withCredentials: false })
        .then((response) => {
          buttonHandler(response.data.authUser, response.data.token);
          navigate(`/user/${response.data.authUser.id}/${data.role}`);
        });
    });
  };

  let form =
    regStep == "firstStep" ? (
      <RegistrationFirstStep
        register={register}
        firstStepHandler={firstStepHandler}
        handleSubmit={handleSubmit}
        errors={errors}
      />
    ) : (
      <RegistrationSecondStep
        register={register}
        handleSubmit={handleSubmit}
        onSubmit={onSubmit}
        secondStepHandler={secondStepHandler}
        errors={errors}
        watch={watch}
      />
    );

  return (
    <div className={style.container}>
      <div className={style.decoration}></div>
      <div className={style.formContainer}>
        <div className={style.title}>
          <p className={style.mainTitle}>Board Meets</p>
          <p className={style.subTitle}>for your fun)</p>
        </div>

        {form}
      </div>
    </div>
  );
};
