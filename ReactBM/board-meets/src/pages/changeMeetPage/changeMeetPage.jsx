import { useParams } from "react-router-dom";
import { ChangeMeetForm } from "../../components/meets/changeMeetForm/changeMeetForm";
import { Title } from "../../components/ui/title/title";
import { getUser } from "../../helpers/getUser";
import { useCheckAuthorization } from "../../hooks/useCheckAuthorization";
import { useDataGet } from "../../hooks/useDataGet";
import style from "./changeMeetPage.module.css";
import { useTranslation } from "react-i18next";

export const ChangeMeetPage = ({ url }) => {
  const { t } = useTranslation();
  let { userId } = useParams();
  let { meetId } = useParams();
  const user = getUser();
  useCheckAuthorization(user?.id, userId);

  const meet = useDataGet(url + `meets/${meetId}`);

  return (
    <div className={style.container}>
      <div className={style.title}>
        <Title content={t("meetsPage.form.titleChange")} />
      </div>
      <ChangeMeetForm userId={userId} url={url} meet={meet} />
    </div>
  );
};
