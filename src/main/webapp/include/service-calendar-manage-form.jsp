<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 18/06/2023
  Time: 9:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8' />
  <script src='./dist/index.global.js'></script>
  <script>

    document.addEventListener('DOMContentLoaded', function() {
      var calendarEl = document.getElementById('calendar');
      var calendar = new FullCalendar.Calendar(calendarEl, {
        initialDate: '${date}',
        editable: true,
        selectable: true,
        businessHours: true,
        dayMaxEvents: true, // allow "more" link when too many events
        dateClick: function(info) {
          // alert('Clicked on: ' + info.dateStr);
      window.location.href = "slotdetail?day="+info.dateStr+"&serviceID=";
          // change the day's background color just for fun
          // info.dayEl.style.backgroundColor = 'red';
        },
        events: [
         <c:forEach  items="${listCalendar}" var="c">
          {
            title: '${c.shiftName}',
            start: '${c.setDay}T${c.startTime}',
            end: '${c.setDay}T${c.endTime}'
          },
          </c:forEach>


        ],
        eventColor: '#FF3333'
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
<h1>Lịch trình của dịch vụ ${serviceID}</h1>
<div id='calendar'></div>
<c:forEach  items="${listCalendar}" var="c">
 ${c.shiftName}
  ${c.setDay}T${c.startTime}
  ${c.setDay}T${c.endTime}

</c:forEach>
${date}

</body>
</html>
