import style from "./meetIndicator.module.css";
export const MeetIndicator = ({ meet }) => {
  
  return (
   <div className={meet.state=="RECRUITING"?style.green:meet.state=="FINISHED"?style.red:style.orange}></div>
  );
}