import style from "./gamesListPage.module.css";
import { GamesList } from "../../components/boardGames/gamesList/gamesList";
import { FilterGames } from "../../components/boardGames/filterGames/filterGames";
import { useForm } from "react-hook-form";
import { useEffect, useState } from "react";

export const GamesListPage = ({ url }) => {
  const { handleSubmit, register } = useForm();
  const [filterStr, setFilterStr] = useState("?");
  const filterHandler = (data) => {
    let str = "";
    for (let elm in data) {
      if (data[elm] !== "") {
        if (elm === "sortDirection" && data[elm]) {
          str += `${elm}=ASC&`;
        } else if (elm === "sortDirection") {
          str += `${elm}=DESC&`;
        } else str += `${elm}=${data[elm]}&`;
      }
    }
    setFilterStr("?" + str);
  };

  return (
    <div className={style.container}>
      <FilterGames
        handleSubmit={handleSubmit}
        register={register}
        filterHandler={filterHandler}
      />
      <GamesList url={url} additionalUrl={filterStr} />
    </div>
  );
};
