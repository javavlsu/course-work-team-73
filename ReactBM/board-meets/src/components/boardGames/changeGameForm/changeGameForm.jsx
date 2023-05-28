import axios from "axios";
import { useEffect, useState } from "react";
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
import style from "./changeGameForm.module.css";
import { useTranslation } from "react-i18next";

export const ChangeGameForm = ({ userId, url, game }) => {
  const { t } = useTranslation();
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
  } = useForm();
  const [image, setImage] = useState(null);
  const navigate = useNavigate();

  const onImageChange = (img) => {
    setImage(URL.createObjectURL(img));
  };

  const deleteHandler = () => {
    axios
      .delete(`${url}boardGames/${game.id}`, getConfig())
      .then(() => navigate(`/games`));
  };

  useEffect(() => {
    if (game != null) {
      setValue("name", game.name);
      setImage(`${url}static/bgAvatar/${game.gameAvatar}`);
      setValue("minPlayers", game.rangeOfPlayersMin);
      setValue("maxPlayers", game.rangeOfPlayersMax);
      setValue("playingTime", game.gameTime);
      setValue("age", game.agePlayer);
      setValue("genre", game.genre);
      setValue("artists", game.artists);
      setValue("publishers", game.publishers);
      setValue("authors", game.authorsGame);
      setValue("description", game.description);
    }
  }, [game]);

  const onSubmit = (data) => {
    let changedGame = new FormData();
    changedGame.append("id", game.id);
    if (data.ruleFile[0]) changedGame.append("rule", data.ruleFile[0]);
    if (data.gameImg[0]) changedGame.append("avatarGame", data.gameImg[0]);
    changedGame.append("name", data.name);
    changedGame.append("rangeOfPlayersMin", data.minPlayers);
    changedGame.append("rangeOfPlayersMax", data.maxPlayers);
    changedGame.append("gameTime", data.playingTime);
    changedGame.append("agePlayer", data.age);
    changedGame.append("authorId", userId);
    changedGame.append("genre", data.genre);
    changedGame.append("artists", data.artists);
    changedGame.append("authorsGame", data.authors);
    changedGame.append("publishers", data.publishers);
    changedGame.append("description", data.description);

    axios
      .put(`${url}boardGames/`, changedGame, getConfig())
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
              required={false}
              notFile={t("boardGamesPage.form.inputGameAvatar.previously")}
              icon={<FileImg />}
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
              required={false}
              icon={<FileRule />}
              name="ruleFile"
              notFile={t("boardGamesPage.form.inputRuleFile.previously")}
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
      <button
        type="button"
        className={style.deleteButton}
        onClick={deleteHandler}
      >
        {t("boardGamesPage.form.deleteBtn")}
      </button>
      <button className={style.changeButton}>
        {" "}
        {t("boardGamesPage.form.changeBtn")}
      </button>
    </form>
  );
};
