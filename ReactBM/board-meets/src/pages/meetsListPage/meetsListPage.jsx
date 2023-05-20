import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { FilterMeets } from "../../components/meets/filterMeets/filterMeets";
import { MeetCard } from "../../components/meets/meetCard/meetCard";
import { MeetsContext } from "../../helpers/meetsContext";
import { useDataGet } from "../../hooks/useDataGet";
import style from "./meetsListPage.module.css";
import { getPageCount, getPagesArray } from "../../helpers/pages";
import { Pagination } from "../../components/pagination/pagination";
import { useTranslation } from "react-i18next";

export const MeetsListPage = ({ url }) => {
  const [meets, setMeets] = useState();
  const [totalPages, setTotalPages] = useState(0);
  const [limit, setLimit] = useState(1);
  const [page, setPage] = useState(0);
  const pageArray = getPagesArray(totalPages);
  const { t } = useTranslation();
  const { handleSubmit, register } = useForm();

  let meetList = useDataGet(url + `meets/?offset=${page}&limit=${limit}`);
  useEffect(() => {
    if (meetList) {
      setMeets(meetList.content);
      setTotalPages(getPageCount(meetList.totalElements, limit));
    }
  }, [meetList]);

  const searchHandler = (data) => {
    axios
      .get(url + `meets/search/${data.city}`)
      .then((response) => {
        setMeets(response.data);
      });
  };

  const deleteMeet = (meet) => {
    setMeets(meets.filter((elem) => elem.id !== meet.id));
  };
  const changeMeet = (meet) => {
    setMeets(
      meets.map((elem) => {
        if (elem.id === meet.id) {
          return meet;
        }
        return elem;
      })
    );
  };

  const getNewPage = (page) => {
    setPage(page);
  };

  return (
    <MeetsContext.Provider value={{ deleteMeet, changeMeet }}>
      <div className={style.container}>
        <FilterMeets
          register={register}
          handleSubmit={handleSubmit}
          searchHandler={searchHandler}
        />
        <ul className={style.meetsList}>
          {!!meets?.length ? (
            meets.map((meet) => (
              <li key={meet.id} className={style.meetsItem}>
                <MeetCard url={url} meet={meet} />
              </li>
            ))
          ) : (
            <p className={style.notFound}>{t("meetsPage.notFound")}</p>
          )}
        </ul>
        <Pagination pageArray={pageArray} getNewPage={getNewPage} page={page} />
      </div>
    </MeetsContext.Provider>
  );
};
