<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Delete Syllabus</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            height: 100vh;
            display: flex;
            flex-direction: column;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        button {
            background-color: #D33A2C; /* Red color */
            color: white;
            font-size: 1rem;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #A5301A;
        }

        .back-btn {
            padding: 10px 20px;
            background-color: #4682B4; /* Mid Blue */
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            display: inline-block;
            margin: 20px auto;
        }

        .back-btn:hover {
            background-color: #315D8D;
        }

        .search-bar {
            width: 50%;
            padding: 10px;
            margin: 20px auto;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1rem;
        }

        .search-btn {
            padding: 10px 20px;
            background-color: #4682B4; /* Mid Blue */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .search-btn:hover {
            background-color: #315D8D;
        }
    </style>
    <script>
        function confirmDelete(syllabusId) {
            if (confirm("Are you sure you want to delete this syllabus?")) {
                document.getElementById('deleteForm-' + syllabusId).submit();
            }
        }
    </script>
</head>
<body>

    <h2>Delete Syllabus</h2>

    <!-- Success or Error Message -->
    <c:if test="${not empty message}">
        <p style="color: green; text-align: center;">${message}</p>
    </c:if>

    <!-- Search Bar -->
    <div style="text-align: center;">
        <input type="text" class="search-bar" id="searchInput" placeholder="Search by Course ID or Content">
        <button class="search-btn" onclick="searchSyllabus()">Search</button>
    </div>

    <!-- Syllabus List Table -->
    <table>
        <thead>
            <tr>
                <th>Syllabus ID</th>
                <th>Course ID</th>
                <th>Content</th>
                <th>Duration</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="syllabus" items="${courses}">
                <tr>
                    <td>${syllabus.syllabusId}</td>
                    <td>${syllabus.course.courseid}</td>
                    <td>${syllabus.syllabusContent}</td>
                    <td>${syllabus.duration}</td>
                    <td>
                        <form id="deleteForm-${syllabus.syllabusId}" method="post"
                              action="${pageContext.request.contextPath}/syllabus/delete/${syllabus.syllabusId}">
                            <button type="button" onclick="confirmDelete(${syllabus.syllabusId})">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Back to Courses Button -->
    <a href="${pageContext.request.contextPath}/home" class="back-btn">Back to Home</a>

    <script>
        function searchSyllabus() {
            let input = document.getElementById('searchInput').value.toLowerCase();
            let rows = document.querySelectorAll("table tbody tr");
            rows.forEach(row => {
                let courseId = row.cells[1].textContent.toLowerCase();
                let content = row.cells[2].textContent.toLowerCase();
                if (courseId.includes(input) || content.includes(input)) {
                    row.style.display = "";
                } else {
                    row.style.display = "none";
                }
            });
        }
    </script>

</body>
</html>
