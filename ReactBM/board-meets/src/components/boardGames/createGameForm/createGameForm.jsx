import axios from "axios";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { getConfig } from "../../../helpers/getConfig";
import { AgeInput } from "../../ui/ageInput/ageInput";
import { ArtistsInput } from "../../ui/artistsInput/artistsInput";
import { AuthorsInput } from "../../ui/authorsInput/authorsInput";
import { GameFileInput } from "../../ui/gameFileInput/gameFileInput";
import { FileImg, FileRule, Genre } from "../../icons/icons";
import { NameInput } from "../../ui/nameInput/nameInput";
import { PlayersInput } from "../../ui/playersInput/playersInput";
import { PlayingTimeInput } from "../../ui/playingTimeInput/playingTimeInput";
import { PublishersInput } from "../../ui/publishersInput/publishersInput";
import style from "./createGameForm.module.css";
import { useTranslation } from "react-i18next";

export const CreateGameForm = ({ userId, url }) => {
  const { t } = useTranslation();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const [image, setImage] = useState(null);
  const navigate = useNavigate();

  const onImageChange = (img) => {
    setImage(URL.createObjectURL(img));
  };

  const onSubmit = (data) => {
    let game = new FormData();
    game.append("rule", data.ruleFile[0]);
    game.append("avatarGame", data.gameImg[0]);
    game.append("name", data.name);
    game.append("rangeOfPlayersMin", data.minPlayers);
    game.append("rangeOfPlayersMax", data.maxPlayers);
    game.append("gameTime", data.playingTime);
    game.append("agePlayer", data.age);
    game.append("authorId", userId);
    game.append("genre", data.genre);
    game.append("artists", data.artists);
    game.append("authorsGame", data.authors);
    game.append("publishers", data.publishers);
    game.append("description", data.description);
    axios
      .post(url + "boardGames/", game, getConfig())
      .then(() => navigate(`/games`));
  };
  return (
    <form className={style.container} onSubmit={handleSubmit(onSubmit)}>
      <fieldset className={style.mainInfoContainer}>
        <div className={style.mainGameInfo}>
          <img
            className={style.gameImg}
            src={image ? image : "/assets/images/background.png"}
            alt="game"
          />
          <div className={style.gameFilesName}>
            <GameFileInput
              register={register}
              icon={<FileImg />}
              required={true}
              notFile={t("boardGamesPage.form.inputGameAvatar.default")}
              name="gameImg"
              message={t("boardGamesPage.form.inputGameAvatar.message")}
              format="image/png, image/jpeg"
              errors={errors}
              onImageChange={onImageChange}
            />
            <div className={style.inputContainer}>
              <NameInput register={register} errors={errors} />
            </div>
            <GameFileInput
              register={register}
              icon={<FileRule />}
              name="ruleFile"
              required={true}
              notFile={t("boardGamesPage.form.inputRuleFile.default")}
              message={t("boardGamesPage.form.inputRuleFile.message")}
              format="application/pdf"
              errors={errors}
            />
            <div className={style.inputContainer}>
              <label htmlFor="genre">
                <Genre width="26" height="26" fill="#057402" />
                <span>{t("boardGamesPage.form.selectGenre.title")}</span>
              </label>
              <select
                className={style.genreInput}
                name="genre"
                id="genre"
                {...register("genre", { required: true })}
              >
                <option value={"Карточная"}>
                  {t("boardGamesPage.form.selectGenre.cardGame")}
                </option>
                <option value={"Ролевая"}>
                  {t("boardGamesPage.form.selectGenre.roleGame")}
                </option>
                <option value={"Игра с костями"}>
                  {t("boardGamesPage.form.selectGenre.diceGame")}
                </option>
                <option
                  value={"Абстрактная"}
                >
                  {t("boardGamesPage.form.selectGenre.abstractGame")}
                </option>
                <option value={"Словестная (контакт)"}>
                  {t("boardGamesPage.form.selectGenre.verbalGame")}
                </option>
                <option value={"Бродилка"}>
                  {t("boardGamesPage.form.selectGenre.walkerGame")}
                </option>
              </select>
            </div>
          </div>
        </div>
        <div className={style.gameProp}>
          <PlayingTimeInput register={register} errors={errors} />
          <PlayersInput register={register} errors={errors} />
          <AgeInput register={register} errors={errors} />
          <AuthorsInput register={register} errors={errors} />
          <ArtistsInput register={register} errors={errors} />
          <PublishersInput register={register} errors={errors} />
        </div>
      </fieldset>
      <fieldset className={style.description}>
        <label htmlFor="description">
          {t("boardGamesPage.gameCard.description")}
          {errors?.description && (
            <span className="error">{errors.description.message}</span>
          )}
        </label>
        <textarea
          id="description"
          name="description"
          placeholder={t("boardGamesPage.form.textarea.placeholder")}
          className={style.textDescription}
          {...register("description", {
            required: t("boardGamesPage.form.textarea.errors.required"),
            maxLength: {
              value: 1560,
              message: t("boardGamesPage.form.textarea.errors.maxLength"),
            },
            minLength: {
              value: 250,
              message: t("boardGamesPage.form.textarea.errors.minLength"),
            },
          })}
        ></textarea>
      </fieldset>

      <button className={style.button}>
        {t("boardGamesPage.form.titleCreate")}
      </button>
    </form>
  );
};
