import { useTranslation } from "react-i18next";
import { Publishers } from "../../icons/icons";
import style from "./publishersInput.module.css";
export const PublishersInput = ({ register, errors }) => {
  const { t } = useTranslation();
  return (
    <>
      <div className={style.container}>
        <label htmlFor="publishers">
          <Publishers />
          <p>{t("boardGamesPage.form.inputPublisher.nameS")}</p>
        </label>
        <input
          type="text"
          id="publishers"
          placeholder="Gaga games, Cosmo game"
          className={errors?.publishers ? style.inputError : style.input}
          {...register("publishers", {
            required: true,
            maxLength: 50,
          })}
        />
      </div>
    </>
  );
};
