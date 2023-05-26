import { useTranslation } from "react-i18next";
import { Authors } from "../../icons/icons";
import style from "./authorsInput.module.css";
export const AuthorsInput = ({ register, errors }) => {
  const { t } = useTranslation();
  return (
    <>
      <div className={style.container}>
        <label htmlFor="authors">
          <Authors />
          <p>{t("boardGamesPage.form.inputAuthor.nameS")}</p>
        </label>
        <input
          type="text"
          id="authors"
          placeholder={t("boardGamesPage.form.inputArtist.placeholder")}
          className={errors?.authors ? style.inputError : style.input}
          {...register("authors", {
            required: true,
            maxLength: 50,
          })}
        />
      </div>
    </>
  );
};
