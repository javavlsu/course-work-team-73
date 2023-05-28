import { useTranslation } from "react-i18next";
import { Players, TimeBold } from "../../icons/icons";
import style from "./playersInput.module.css";
export const PlayersInput = ({ register, errors }) => {
  const { t } = useTranslation();
  return (
    <>
      <div className={style.container}>
        <label htmlFor="minPlayers">
          <Players fill="#057402" />
          <p>{t("boardGamesPage.form.inputMembersCount.name")}</p>
        </label>
        <input
          type="text"
          id="minPlayers"
          placeholder="2"
          className={errors?.minPlayers ? style.inputError : style.input}
          {...register("minPlayers", {
            required: "введите мин.значение",
            pattern: {
              value: /^\d+$/,
            },
            max: {
              value: 20,
            },
            min: {
              value: 1,
            },
          })}
        />
        <p>{t("boardGamesPage.form.inputMembersCount.to")}</p>
        <input
          type="text"
          id="maxPlayers"
          placeholder="5"
          className={errors?.maxPlayers ? style.inputError : style.input}
          {...register("maxPlayers", {
            required: true,
            pattern: {
              value: /^\d+$/,
            },
            max: {
              value: 20,
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
