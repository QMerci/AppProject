const daysContainer = document.querySelector(".days");
const month = document.querySelector(".month");
const todayBtn = document.querySelector(".today-btn");
const months = ["Leden", "Únor", "Březen", "Duben", "Květen", "Červen", "Červenec", "Srpen", "Září", "Říjen", "Listopad", "Prosinec"];
const date = new Date();
let currentMonth = date.getMonth();
let currentYear = date.getFullYear();
function renderCalendar() {
    date.setDate(1);
    const lastDay = new Date(currentYear, currentMonth + 1, 0);
    const lastDayDate = lastDay.getDate();
    month.innerHTML = `${months[currentMonth]} ${currentYear}`;
    let days = "";
    for (let i = 1; i <= lastDayDate; i++) {
        if (
            i === new Date().getDate() &&
            currentMonth === new Date().getMonth() &&
            currentYear === new Date().getFullYear()
        ) {
            days += `<div class="day today">${i}</div>`;
        } else {
            days += `<div class="day">${i}</div>`;
        }
    }
    daysContainer.innerHTML = days;
}
renderCalendar();
todayBtn.addEventListener("click", () => {
    currentMonth = date.getMonth();
    currentYear = date.getFullYear();
    renderCalendar();
});