<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Syllabus List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }
        th {
            background-color: #4682B4; /* Mid Blue */
            color: white;
            padding: 10px;
            text-align: left;
        }
        td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        .search-box {
            width: 60%;
            padding: 10px;
            margin: 10px auto;
            display: block;
            border: 1px solid #ddd;
            border-radius: 5px;
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
            padding: 2px 12px;
            text-align: left;
            text-decoration: none;
            transition: border .2s ease-in-out, box-shadow .2s ease-in-out;
        }
        .button-45:active, .button-45:hover, .button-45:focus {
            outline: 0;
        }
        .button-45:active {
            background-color: #D33A2C;
            box-shadow: rgba(0, 0, 0, 0.12) 0 1px 3px 0 inset;
            color: #FFFFFF;
        }
        .button-45:hover {
            background-color: #FFE3E3;
            border-color: #FAA4A4;
        }
        .button-45:active:hover, .button-45:focus:hover, .button-45:focus {
            background-color: #D33A2C;
            box-shadow: rgba(0, 0, 0, 0.12) 0 1px 3px 0 inset;
            color: #FFFFFF;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: black;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-btn:hover {
            background-color: #333;
        }
    </style>
</head>
<body>

    <h2>Syllabus List for Course ID: ${course.courseid} - ${course.name}</h2>

    <!-- Search Bar -->
    <input type="text" id="searchBox" class="search-box" placeholder="Search by syllabus content..." onkeyup="searchSyllabus()">

    <!-- Syllabus List Table -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Course ID</th>
                <th>Content</th>
                <th>Duration</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody id="syllabusTable">
            <c:forEach var="syllabus" items="${syllabusList}">
                <tr class="syllabus-row">
                    <td>${syllabus.syllabusId}</td>
                    <td>${syllabus.course.courseid}</td>
                    <td>${syllabus.syllabusContent}</td>
                    <td>${syllabus.duration}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/syllabus/update/${syllabus.syllabusId}">
                            <button class="button-45">Update</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Back Button -->
    <a href="${pageContext.request.contextPath}/home" class="back-btn">Back to Home</a>

    <script>
        // Search functionality for syllabi
        function searchSyllabus() {
            let input = document.getElementById("searchBox").value.toLowerCase();
            let rows = document.getElementsByClassName("syllabus-row");
            
            let noResults = true;
            for (let row of rows) {
                let content = row.getElementsByTagName("td")[2].textContent.toLowerCase();
                if (content.includes(input)) {
                    row.style.display = "";
                    noResults = false;
                } else {
                    row.style.display = "none";
                }
            }
        }
    </script>

</body>
</html>
