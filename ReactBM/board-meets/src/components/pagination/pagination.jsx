import style from "./pagination.module.css";

export const Pagination = ({pageArray, getNewPage, page}) => {
  return (
    <ul className={style.pageList}>
      {pageArray.length > 1 &&
        pageArray.map((i) => (
          <li
            className={
              i === page
                ? `${style.activePage} ${style.defaultPage}`
                : style.defaultPage
            }
            key={i}
            onClick={() => getNewPage(i)}
          >
            {i + 1}
          </li>
        ))}
    </ul>
  );
};
