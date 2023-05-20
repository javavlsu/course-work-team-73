export const stringToDate = (date) => {

  let realDate = new Date(date);
  return (realDate);
};
export const getMonthDay = (date, t) => {
  let months = [t("meetsPage.meet.months.january"), "Февраля", "Марта", "Апреля", t("meetsPage.meet.months.may"), "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"];
  let realDate = new Date(date);

  return (realDate.getDate().toString() + " " + months[realDate.getMonth()]);
};
export const getTime = (date) => {

  let realDate = new Date(date);

  return (realDate.toLocaleTimeString().slice(0, -3));
};
export const getDateFormat = (date) => {

  let realDate = new Date(date);
  let month = realDate.getMonth() + 1 < 10 ? "0" + (parseInt(realDate.getMonth()) + 1) : realDate.getMonth() + 1;
  let day = realDate.getDate() < 10 ? "0" + realDate.getDate() : realDate.getDate();
  return (realDate.getFullYear() + "-" + month + "-" + day).toString();
};
