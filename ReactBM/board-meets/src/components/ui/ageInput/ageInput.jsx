import { useTranslation } from "react-i18next";
import { Age, TimeBold } from "../../icons/icons";
import style from "./ageInput.module.css";
export const AgeInput = ({ register, errors }) => {
  const { t } = useTranslation();
  return (
    <>
      <div className={style.container}>
        <label htmlFor="age">
          <Age fill="#057402" />
          <p>{t("boardGamesPage.form.ageInput")}</p>
        </label>
        <input
          type="text"
          id="age"
          placeholder="12"
          className={errors?.age ? style.inputError : style.input}
          {...register("age", {
            required: true,
            pattern: {
              value: /^\d+$/,
            },
            max: {
              value: 100,
            },
            min: {
              value: 1,
            },
          })}
        />
      </div>
    </>
  );
};
