<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="appheader.jsp" %>

<div class="m-4 p-4 width-medium">
    <div class="dashboard-header m-4">
        <div class="dashboard-menu">
            <div class="menu-item border-dashed">
                <a href="/app/training/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">Add training</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/app/dashboard/${previousIndex}">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">Previous Training</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/app/dashboard">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">Next Training</span>
                </a>
            </div>
        </div>

        <div class="dashboard-alerts">
            <div class="alert-item alert-info">
                <i class="fas icon-circle fa-info-circle"></i>
                <span class="font-weight-bold">No. All Trainings: ${numberOfTrainings}</span>
            </div>
            <div class="alert-item alert-light">
                <i class="far icon-calendar fa-calendar-alt"></i>
                <span class="font-weight-bold">No. All Burned Calories: ${numberOfBurnedCalories}</span>
            </div>
        </div>
    </div>
    <div class="m-4 p-4 border-dashed">
        <h2 class="dashboard-content-title">
            <span>Last Training:</span> no. ${training.id}
        </h2>
        <h2 class="dashboard-content-title">
            <span> when: </span> ${training.trainingDay}
        </h2>
        <h2 class="dashboard-content-title">
            <span> time: </span> ${training.trainingTime}
        </h2>
        <h2 class="dashboard-content-title">
            <span> average running pace: </span> ${trainingDetail.temp}
        </h2>
        <h2 class="dashboard-content-title">
            <span> distance: </span> ${trainingDetail.kilometers}km
        </h2>
        <h2 class="dashboard-content-title">
            <span> burned calories: </span>${trainingDetail.kcal}
        </h2>
        <h2 class="dashboard-content-title">
            <span> description: </span> ${training.description}
        </h2>
    </div>
</div>
</div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
<%@include file="footer.jsp" %>