import { useTranslation } from "react-i18next";
import { Rules } from "../../icons/icons";
import style from "./description.module.css";

export const Description = ({ game, url }) => {
  const { t } = useTranslation();

  return (
    <div className={style.wrapper}>
      <p className={style.title}>{t("boardGamesPage.gameCard.description")}</p>
      <p className={style.content}>{game?.description}</p>
      <a
        className={style.rulesFile}
        href={`${url}static/rule/${game?.rule}`}
        target="_blank"
        rel="noopener noreferrer"
      >
        <Rules />
        <p className={style.rulesIcon}>{t("boardGamesPage.gameCard.gameRule")}</p>
      </a>
    </div>
  );
};
