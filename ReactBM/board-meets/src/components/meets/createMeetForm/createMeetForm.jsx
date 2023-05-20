import axios from "axios";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { getConfig } from "../../../helpers/getConfig";
import {
  CityMeet,
  Communication,
  Date,
  LightMaxTime,
  LightPlayers,
  Location,
  MinusButton,
  PlusButton,
  Time,
  Write,
} from "../../icons/icons";
import style from "./createMeetForm.module.css";
import { useTranslation } from "react-i18next";

export const CreateMeetForm = ({ userId, url }) => {
  const { t } = useTranslation();
  const {
    register,
    handleSubmit,
    formState: { errors },
    getValues,
  } = useForm();
  const [gameList, setGameList] = useState([]);
  const navigate = useNavigate();

  const onSubmit = (data) => {
    const body = {
      name: data.name,
      peopleCountMax: data.players,
      duration: data.maxTime,
      link: data.communication,
      date: data.date + " " + data.time + ":00",
      city: data.city,
      location: data.location,
      games: `${JSON.stringify(gameList)}`,
      authorId: userId,
    };
    axios.post(url + "meets/", body, getConfig()).then(() => navigate(`/`));
  };

  const plusButtonHandler = () => {
    const game = getValues("game");
    if (game && gameList.indexOf(game) == -1) {
      setGameList([...gameList, game]);
    }
  };

  const minusButtonHandler = (value) => {
    setGameList(gameList.filter((p) => p !== value));
  };

  return (
    <form className={style.container} onSubmit={handleSubmit(onSubmit)}>
      <div className={style.mainInfo}>
        <div className={style.namePlayersTime}>
          <label className={style.inputLabel} htmlFor="name">
            {t("meetsPage.form.inputName.name")}
          </label>
          <div className={style.inputName} id="name">
            <label className={style.inputIcon} htmlFor="name">
              <Write />
            </label>
            <input
              type="text"
              id="name"
              className={style.input}
              placeholder={t("meetsPage.form.inputName.placeholder")}
              {...register("name", {
                required: t("meetsPage.form.inputName.errors.required"),
                maxLength: {
                  value: 20,
                  message: t("meetsPage.form.inputName.errors.maxLength"),
                },
                minLength: {
                  value: 5,
                  message: t("meetsPage.form.inputName.errors.minLength"),
                },
              })}
            />
            {errors?.name && <p className="error">{errors.name.message}</p>}
          </div>

          <label className={style.inputLabel} htmlFor="playersTime">
            {t("meetsPage.form.inputMembersCount.name")}
          </label>
          <div className={style.playersTime} id="playersTime">
            <div className={style.inputPlayers}>
              <label className={style.inputIcon} id="players">
                <LightPlayers />
              </label>
              <input
                type="number"
                id="players"
                className={style.input}
                placeholder="10"
                {...register("players", {
                  required: t(
                    "meetsPage.form.inputMembersCount.errors.required"
                  ),
                  pattern: {
                    value: /^\d+$/,
                    message: t(
                      "meetsPage.form.inputMembersCount.errors.pattern"
                    ),
                  },
                  max: {
                    value: 250,
                    message: t(
                      "meetsPage.form.inputMembersCount.errors.maxValue"
                    ),
                  },
                  min: {
                    value: 1,
                    message: t(
                      "meetsPage.form.inputMembersCount.errors.minValue"
                    ),
                  },
                })}
              />
              {errors?.players && (
                <p className="error">{errors.players.message}</p>
              )}
            </div>
            <div className={style.inputMaxTime}>
              <label className={style.inputIcon} htmlFor="maxTime">
                <LightMaxTime />
              </label>
              <input
                type="text"
                id="maxTime"
                className={style.input}
                placeholder="1"
                {...register("maxTime", {
                  required: t("meetsPage.form.inputMeetTime.errors.required"),
                  pattern: {
                    value: /^\d+$/,
                    message: t("meetsPage.form.inputMeetTime.errors.pattern"),
                  },
                  max: {
                    value: 1200,
                    message: t("meetsPage.form.inputMeetTime.errors.maxValue"),
                  },
                  min: {
                    value: 10,
                    message: t("meetsPage.form.inputMeetTime.errors.minValue"),
                  },
                })}
              />
              {errors?.maxTime && (
                <p className="error">{errors.maxTime.message}</p>
              )}
            </div>
          </div>
        </div>
        <div className={style.verticalLine}></div>
        <div className={style.dateTimeLocation}>
          <label className={style.inputLabel}>
            {t("meetsPage.form.inputDateTime.name")}
          </label>
          <div className={style.dateTime}>
            <div className={style.inputDate}>
              <label className={style.inputIcon} htmlFor="date">
                <Date />
              </label>
              <input
                type="date"
                id="date"
                className={style.date}
                {...register("date", {
                  required: t(
                    "meetsPage.form.inputDateTime.errors.requiredDate"
                  ),
                })}
              />
              {errors?.date && <p className="error">{errors.date.message}</p>}
            </div>
            <div className={style.inputTime}>
              <label className={style.inputIcon} htmlFor="time">
                <Time />
              </label>
              <input
                type="time"
                id="time"
                className={style.time}
                {...register("time", {
                  required: t(
                    "meetsPage.form.inputDateTime.errors.requiredTime"
                  ),
                })}
              />
              {errors?.time && <p className="error">{errors.time.message}</p>}
            </div>
          </div>
          <div className={style.inputCity}>
            <label className={style.inputIcon} htmlFor="city">
              <CityMeet />
            </label>
            <input
              type="text"
              id="city"
              className={style.input}
              placeholder={t("meetsPage.form.inputDateTime.placeholders.city")}
              {...register("city", {
                required: t("meetsPage.form.inputDateTime.errors.requiredCity"),
                maxLength: {
                  value: 25,
                  message: t(
                    "meetsPage.form.inputDateTime.errors.cityMaxLength"
                  ),
                },
              })}
            />
            {errors?.city && <p className="error">{errors.city.message}</p>}
          </div>
          <div className={style.inputLocation}>
            <label className={style.inputIcon} htmlFor="location">
              <Location />
            </label>
            <input
              type="text"
              id="location"
              className={style.input}
              placeholder={t(
                "meetsPage.form.inputDateTime.placeholders.location"
              )}
              {...register("location", {
                required: t(
                  "meetsPage.form.inputDateTime.errors.requiredLocation"
                ),
                maxLength: {
                  value: 25,
                  message: t(
                    "meetsPage.form.inputDateTime.errors.locationMaxLength"
                  ),
                },
              })}
            />
            {errors?.location && (
              <p className="error">{errors.location.message}</p>
            )}
          </div>
        </div>
      </div>
      <div className={style.moreInfo}>
        <div className={style.communicationGames}>
          <div className={style.communication}>
            <label className={style.inputGreenLabel}>
              {t("meetsPage.form.inputLink.name")}
            </label>
            <div className={style.communicationInput}>
              <label className={style.inputIcon} htmlFor="communication">
                <Communication />
              </label>
              <input
                type="text"
                id="communication"
                className={style.input}
                placeholder="https://t.me/channelname"
                maxLength="25"
                {...register("communication", {
                  maxLength: {
                    value: 25,
                    message: t("meetsPage.form.inputLink.maxLength"),
                  },
                })}
              />
              {errors?.communication && (
                <p className="error">{errors.communication.message}</p>
              )}
            </div>
          </div>
          <div className={style.games}>
            <label className={style.inputGreenLabel}>
              {t("meetsPage.form.inputGames.name")}
            </label>
            <div className={style.gamesInput}>
              <label className={style.inputIcon} htmlFor="game">
                <button
                  type="button"
                  className={style.plusButton}
                  onClick={plusButtonHandler}
                >
                  <PlusButton />
                </button>
              </label>
              <input
                type="text"
                id="game"
                className={style.input}
                placeholder={t("meetsPage.form.inputGames.placeholder")}
                maxLength="25"
                {...register("game")}
              />
            </div>
            <ul className={style.gamesList}>
              {gameList?.length != 0 &&
                gameList?.length &&
                gameList.map((game) => (
                  <li key={gameList.indexOf(game)} className={style.gameItem}>
                    <button
                      type="button"
                      className={style.minusButton}
                      onClick={() => minusButtonHandler(game)}
                    >
                      <MinusButton />
                    </button>
                    {game}
                  </li>
                ))}
            </ul>
          </div>
        </div>
        <button className={style.buttonCreateMeet}>
          {t("meetsPage.form.createBtn")}
        </button>
      </div>
    </form>
  );
};
