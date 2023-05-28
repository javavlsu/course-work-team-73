import { useTranslation } from "react-i18next";
import { Age, Write } from "../../icons/icons";
import style from "./nameInput.module.css";
export const NameInput = ({ register, errors }) => {
  const { t } = useTranslation();
  return (
    <>
      <div className={style.container}>
        <label htmlFor="age">
          <Write width="20" height="20" stroke="#057402" />
          <p>{t("boardGamesPage.form.inputName.name")}</p>
        </label>
        <input
          type="text"
          id="name"
          placeholder={t("boardGamesPage.form.inputName.placeholder")}
          className={errors?.name ? style.inputError : style.input}
          {...register("name", {
            required: true,
            maxLength: 30,
          })}
        />
      </div>
    </>
  );
};
