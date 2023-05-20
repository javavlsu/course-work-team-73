import { useParams } from "react-router-dom";
import { CreateMeetForm } from "../../components/meets/createMeetForm/createMeetForm";
import { Title } from "../../components/ui/title/title";
import { getUser } from "../../helpers/getUser";
import { useCheckAuthorization } from "../../hooks/useCheckAuthorization";
import style from "./createMeetPage.module.css";
import { useTranslation } from "react-i18next";

export const CreateMeetPage = ({ url }) => {
  const { t } = useTranslation();
  let { userId } = useParams();
  const user = getUser();
  useCheckAuthorization(user?.id, userId);

  return (
    <div className={style.container}>
      <div className={style.title}>
        <Title content={t("meetsPage.form.titleCreate")} />
      </div>
      <CreateMeetForm userId={userId} url={url} />
    </div>
  );
};
