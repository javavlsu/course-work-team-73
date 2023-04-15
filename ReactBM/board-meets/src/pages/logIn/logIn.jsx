import { useNavigate, NavLink } from "react-router-dom";
import style from "./logIn.module.css";
import { Back, Write } from "../../components/icons/icons";
import { useForm } from "react-hook-form";
import axios from "axios";
import { useState } from "react";

export const LogIn = ({ buttonHandler, url }) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const navigate = useNavigate();
  const [errMes, setErrMes] = useState(null);

  const onSubmit = (data) => {
    const body = { username: data.userName, password: data.password };
    axios
      .post(url + "auth/login", body, { withCredentials: false })
      .then((response) => {
        buttonHandler(response.data.authUser, response.data.token);
      })
      .then(() => navigate("/"))
      .catch((err) => {
        if (err.response) {
          setErrMes(<p class="error">Неверный пароль или логин </p>);
        }
      });
  };

  return (
    <div className={style.container}>
      <div className={style.decoration}></div>
      <div className={style.formContainer}>
        <div className={style.title}>
          <p className={style.mainTitle}>Board Meets</p>
          <p className={style.subTitle}>for your fun)</p>
        </div>
        <form className={style.form} onSubmit={handleSubmit(onSubmit)}>
          <p className={style.formTitle}>Вход</p>
          <div className={style.formInput}>
            <label className={style.mandatoryLabel}>Обязательно</label>
            <input
              type="input"
              className={style.input}
              placeholder=" "
              {...register("userName", {
                required: "введите свой никнейм",
                pattern: {
                  value: /^([a-zA-z0-9_]{1,23})$/,
                  message: "никнейм введен некорректно",
                },
              })}
            />
            {errors?.userName && (
              <p className="error">{errors.userName.message}</p>
            )}
            <label className={style.swimLabel}>Никнейм</label>
          </div>
          <div className={style.formInput}>
            <label className={style.mandatoryLabel}>Обязательно</label>
            <input
              type="password"
              className={style.input}
              autoComplete="off"
              placeholder=" "
              {...register("password", {
                required: "введите свой пароль",
              })}
            />
            {errors?.password && (
              <p className="error">{errors.password.message}</p>
            )}
            <label className={style.swimLabel}>Пароль</label>
          </div>
          {errMes}
          <input
            type="submit"
            className={style.formButton}
            value="Вход"
          ></input>
          <div className={style.links}>
            <NavLink to="/" className={style.navLink}>
              <Back />
              Продолжить без регистрации
            </NavLink>
            <NavLink to="/registration" className={style.navLink}>
              <Write stroke="black" width="13" height="13" />
              Регистрация
            </NavLink>
          </div>
        </form>
      </div>
    </div>
  );
};
