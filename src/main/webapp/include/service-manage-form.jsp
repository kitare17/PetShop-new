<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 18/06/2023
  Time: 9:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>\
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8' />
  <script src='./dist/index.global.js'></script>
  <script>

    document.addEventListener('DOMContentLoaded', function() {
      var calendarEl = document.getElementById('calendar');
      var calendar = new FullCalendar.Calendar(calendarEl, {
        initialDate: '2023-01-12',
        editable: true,
        selectable: true,
        businessHours: true,
        dayMaxEvents: true, // allow "more" link when too many events
        dateClick: function(info) {
          // alert('Clicked on: ' + info.dateStr);
      window.location.href = "slotdetail?day="+info.dateStr;
          // change the day's background color just for fun
          // info.dayEl.style.backgroundColor = 'red';
        },
        events: [
          {
            title: 'Slot1',
            start: '2023-01-01T10:30:00',
            end: '2023-01-01T12:30:00'
          },

          {
            title: 'Meeting',
            start: '2023-01-12T10:30:00',
            end: '2023-01-12T12:30:00'
          },
          {
            title: 'Lunch',
            start: '2023-01-12T12:00:00'
          },
          {
            title: 'Meeting',
            start: '2023-01-12T14:30:00'
          },
          {
            title: 'Happy Hour',
            start: '2023-01-12T17:30:00'
          }

        ]
      });

      calendar.render();
    });

  </script>
  <script>
    document.addEventListener('DOMContentLoaded', function() {
      // page is now ready, initialize the calendar...
      // options and github  - http://fullcalendar.io/

      var calendar = document.getElementById('calendar');
      calendar.addEventListener('click', function(event) {
        if (event.target.classList.contains('fc-day-top')) {
          var date = event.target.getAttribute('data-date');
          alert('a day has been clicked!' + date);
          console.log(date);
          // window.location.href = "https://chatbot.theb.ai/#/chat/1686840386936";
        }
      });
    });

  </script>
  <style>

    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }

  </style>
</head>
<body>

<div id='calendar'></div>



</body>
</html>
