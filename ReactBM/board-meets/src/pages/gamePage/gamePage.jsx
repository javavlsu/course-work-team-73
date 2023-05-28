import { useParams } from "react-router-dom";
import { CommentBlock } from "../../components/comments/commentBlock/commentBlock";
import { Description } from "../../components/boardGames/description/description";
import { GameReadCard } from "../../components/boardGames/gameReadCard/gameReadCard";
import { useDataGet } from "../../hooks/useDataGet";
import style from "./gamePage.module.css";
import { useTranslation } from "react-i18next";

export const GamePage = ({ url }) => {
  const { t } = useTranslation();
  let { gameId } = useParams();
  const game = useDataGet(url + "boardGames/" + gameId);
  switch (game?.genre) {
    case "Карточная":
    case "Card game":
      game.genre = t("boardGamesPage.form.selectGenre.cardGame");
      break;
    case "Ролевая":
    case "Roleplay":
      game.genre = t("boardGamesPage.form.selectGenre.roleGame");
      break;
    case "Игра с костями":
    case "Dice game":
      game.genre = t("boardGamesPage.form.selectGenre.diceGame");
      break;
    case "Абстрактная":
    case "Abstract game":
      game.genre = t("boardGamesPage.form.selectGenre.abstractGame");
      break;
    case "Словестная (контакт)":
    case "Verbal (contact)":
      game.genre = t("boardGamesPage.form.selectGenre.verbalGame");
      break;
    case "Бродилка":
    case "Walker game":
      game.genre = t("boardGamesPage.form.selectGenre.walkerGame");
      break;
  }
  return (
    <div className={style.container}>
      <div className={style.articleItem}>
        <GameReadCard game={game} url={url} />
      </div>
      <div className={style.articleItem}>
        <Description game={game} url={url} />
      </div>
      <CommentBlock game={game} url={url} />
    </div>
  );
};
