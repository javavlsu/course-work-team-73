import { useParams } from "react-router-dom";
import { CreateGameForm } from "../../components/boardGames/createGameForm/createGameForm";
import { Title } from "../../components/ui/title/title";
import { getUser } from "../../helpers/getUser";
import { useCheckAuthorization } from "../../hooks/useCheckAuthorization";
import style from "./createGamePage.module.css";
import { useTranslation } from "react-i18next";

export const CreateGamePage = ({ url }) => {
  const { t } = useTranslation();
  let { userId } = useParams();
  const user = getUser();
  useCheckAuthorization(user?.id, userId);

  return (
    <div className={style.container}>
      <div className={style.title}>
        <Title content={t("boardGamesPage.form.titleCreate")} />
      </div>
      <CreateGameForm userId={userId} url={url} />
    </div>
  );
};
