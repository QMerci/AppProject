google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    let data = google.visualization.arrayToDataTable([
        ['Year', 'Sales', 'Expenses', 'Profit'],
        ['2021', 1000, 400, 200],
        ['2022', 1170, 460, 250],
        ['2023', 660, 1120, 300],
        ['2024', 1030, 540, 350]
    ]);

    let options = {
        chart: {
            title: 'Stav případů',
        },
        colors: ['#b5f3af', '#000000', '#a1a1a1']
    };

    let chart = new google.charts.Bar(document.getElementById('columnchart_material'));

    chart.draw(data, google.charts.Bar.convertOptions(options));
}