import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { FilterMeets } from "../../components/filterMeets/filterMeets";
import { MeetCard } from "../../components/meetCard/meetCard";
import { MeetsContext } from "../../helpers/meetsContext";
import { getConfig } from "../../helpers/getConfig";
import { useDataGet } from "../../hooks/useDataGet";
import style from "./meetsListPage.module.css";
import { getPageCount, getPagesArray } from "../../helpers/pages";
import { Pagination } from "../../components/pagination/pagination";

export const MeetsListPage = ({ url }) => {
  const [meets, setMeets] = useState();
  const [totalPages, setTotalPages] = useState(0);
  const [limit, setLimit] = useState(5);
  const [page, setPage] = useState(0);
  const pageArray = getPagesArray(totalPages);
  const { handleSubmit, register } = useForm();

  let meetList = useDataGet(url + `meets/?offset=${page}&limit=${limit}`);
  useEffect(() => {
    if (meetList) {
      setMeets(meetList.content);
      setTotalPages(getPageCount(meetList.totalElements, limit));
    }
  }, [meetList]);

  const searchHandler = (data) => {
    let body = data.date
      ? { city: data.city, date: data.date }
      : { city: data.city };
    axios.post(url + "Meets/Search", body, getConfig()).then((response) => {
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
  }

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
            <p className={style.notFound}>Мероприятия не найдены 👽</p>
          )}
        </ul>
        <Pagination pageArray={pageArray} getNewPage={getNewPage} page={page}/>

      </div>
    </MeetsContext.Provider>
  );
};
