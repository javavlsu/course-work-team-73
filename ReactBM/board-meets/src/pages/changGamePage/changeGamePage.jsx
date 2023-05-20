import { useParams } from "react-router-dom";
import { ChangeGameForm } from "../../components/boardGames/changeGameForm/changeGameForm";
import { Title } from "../../components/ui/title/title";
import { getUser } from "../../helpers/getUser";
import { useCheckAuthorization } from "../../hooks/useCheckAuthorization";
import { useDataGet } from "../../hooks/useDataGet";
import style from "./changeGamePage.module.css";
import { useTranslation } from "react-i18next";

export const ChangeGamePage = ({ url }) => {
  const { t } = useTranslation();
  let { userId } = useParams();
  let { gameId } = useParams();
  const user = getUser();
  useCheckAuthorization(user?.id, userId);

  const game = useDataGet(url + `boardGames/${gameId}`);

  return (
    <div className={style.container}>
      <div className={style.title}>
        <Title content={t("boardGamesPage.form.titleChange")} />
      </div>
      <ChangeGameForm userId={userId} url={url} game={game} />
    </div>
  );
};
