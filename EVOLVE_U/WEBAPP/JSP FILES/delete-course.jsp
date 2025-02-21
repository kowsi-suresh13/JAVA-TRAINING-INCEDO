<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Delete Course</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h2 {
            margin-top: 20px;
            color: #333;
        }
        #searchBox {
            width: 60%;
            padding: 10px;
            margin: 20px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background: #507DBC; /* Midblue */
            color: white;
        }
        .button-45 {
            align-items: center;
            background-color: #FFE7E7;
            border: 1px solid #FEE0E0;
            border-radius: 11px;
            color: #D33A2C;
            cursor: pointer;
            font-size: 1rem;
            font-weight: 700;
            padding: 5px 12px;
            text-decoration: none;
            transition: border .2s ease-in-out, box-shadow .2s ease-in-out;
        }
        .button-45:hover {
            background-color: #FFE3E3;
            border-color: #FAA4A4;
        }
        .button-45:active {
            background-color: #D33A2C;
            color: white;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            background: #28a745;
            padding: 10px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .message {
            color: green;
            font-weight: bold;
        }
    </style>

    <script>
        function deleteCourse(courseId) {
            if (confirm("Are you sure you want to delete this course?")) {
                fetch('${pageContext.request.contextPath}/courses/delete/' + courseId, {
                    method: 'POST'
                })
                .then(response => response.text())
                .then(data => {
                    alert(data);
                    location.reload(); // Refresh page after deletion
                })
                .catch(error => console.error('Error:', error));
            }
        }

        function searchCourse() {
            let input = document.getElementById("searchBox").value.toLowerCase();
            let rows = document.getElementsByClassName("course-row");

            let noResults = true;
            for (let row of rows) {
                let courseName = row.getElementsByTagName("td")[1].textContent.toLowerCase();
                if (courseName.includes(input)) {
                    row.style.display = "";
                    noResults = false;
                } else {
                    row.style.display = "none";
                }
            }

            document.getElementById("noResultsMessage").style.display = noResults ? "block" : "none";
        }
    </script>
</head>
<body>

    <h2>Delete Course</h2>

    <!-- Success or Error Message -->
    <% String message = (String) request.getAttribute("message");
       if (message != null) { %>
       <p class="message"><%= message %></p>
    <% } %>

    <!-- Search Box -->
    <input type="text" id="searchBox" placeholder="Search by course name..." onkeyup="searchCourse()">

    <!-- Course List Table -->
    <table>
        <tr>
            <th>Course ID</th>
            <th>Course Code</th>
            <th>Name</th>
            <th>Description</th>
            <th>Duration (days)</th>
            <th>Price ($)</th>
            <th>Action</th>
        </tr>
        <tbody id="courseTable">
            <c:forEach var="course" items="${courses}">
                <tr class="course-row">
                    <td>${course.courseid}</td>
                    <td>${course.courseCode}</td>
                    <td>${course.name}</td>
                    <td>${course.description}</td>
                    <td>${course.duration}</td>
                    <td>${course.price}</td>
                    <td>
                        <button class="button-45" onclick="deleteCourse(${course.courseid})">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- No Results Message -->
    <p id="noResultsMessage" style="display: none; color: red; font-weight: bold;">No Course Found</p>

    <!-- Back to Home Button -->
    <a href="${pageContext.request.contextPath}/home" class="back-btn">Back to Home</a>

</body>
</html>
