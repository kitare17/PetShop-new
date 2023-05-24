<%-- 
    Document   : chart
    Created on : Mar 22, 2023, 1:35:10 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/pluscharts.css">
        <script src="https://d3js.org/d3.v5.min.js"></script>
        <script src="dist/pluscharts.js"></script>
    </head>
    <body>

        <div class="d-flex">
            <div class="col-md-6" id="column-chart"></div>
            <div class="" id="column-chart2"></div>
        </div>
        <script>
            
            pluscharts.draw({
                drawOn: '#column-chart',
                type: "column",
                dataset: {
                    data: [
                        
        <c:forEach items="${chart.getAllAge()}" var="i" >
                     {
                            label: ${i.age},
                            value: ${i.amount}
                        },    
        </c:forEach>
                      
                    ],
                    backgroundColor: "#5d62b4", //can be array or single color
                    borderColor: "#5d62b4",
                    borderWidth: 0,
                    legendLabel: "Thống kê độ tuổi của người dùng"
                },
                options: {
                    barPadding: .65,
                    barWidth: 15,
                    text: {
                        display: false,
                        color: "#6c478c"
                    },
                    axes: {
                        x: {
                            display: true,
                            min: 0,
                            max: 100
                        },
                        y: {
                            display: true,
                            min: 0,
                            max: 100
                        }
                    },
                    legends: {
                        display: true,
                        width: 20,
                        height: 20
                    },
                    size: {
                        width: '400', //give 'container' if you want width and height of initiated container
                        height: '400'
                    }
                }
            });


           
           pluscharts.draw({
                drawOn: '#column-chart2',
                type: "column",
                dataset: {
                    data: [
                        
        <c:forEach items="${chart.getAllOrderMonth()}" var="i"  >
                     {
                            label: ${i.age},
                            value: ${i.amount}
                        },    
        </c:forEach>
                      
                    ],
                    backgroundColor: "#7AB730", //can be array or single color
                    borderColor: "#7AB730",
                    borderWidth: 0,
                    legendLabel: "Doanh số bán hàng theo tháng năm 2023"
                },
                options: {
                    barPadding: .65,
                    barWidth: 15,
                    text: {
                        display: false,
                        color: "#7AB730"
                    },
                    axes: {
                        x: {
                            display: true,
                            min: 0,
                            max: 100
                        },
                        y: {
                            display: true,
                            min: 0,
                            max: 100
                        }
                    },
                    legends: {
                        display: true,
                        width: 20,
                        height: 20
                    },
                    size: {
                        width: '400', //give 'container' if you want width and height of initiated container
                        height: '400'
                    }
                }
            })

        </script>
    </body>
</html>
