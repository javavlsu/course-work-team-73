import { useTranslation } from "react-i18next";
import { Artists } from "../../icons/icons";
import style from "./artistsInput.module.css";
export const ArtistsInput = ({ register, errors }) => {
  const { t } = useTranslation();
  return (
    <>
      <div className={style.container}>
        <label htmlFor="artists">
          <Artists />
          <p>{t("boardGamesPage.form.inputArtist.nameS")}</p>
        </label>
        <input
          type="text"
          id="artists"
          placeholder={t("boardGamesPage.form.inputArtist.placeholder")}
          className={errors?.artists ? style.inputError : style.input}
          {...register("artists", {
            required: true,
            maxLength: 50,
          })}
        />
      </div>
    </>
  );
};
