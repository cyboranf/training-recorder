<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="appheader.jsp" %>

<div class="m-4 p-3 width-medium">
  <div class="dashboard-content border-dashed p-3 m-4 view-height">
    <!-- fix action, method -->
    <!-- add name attribute for all inputs -->
    <form action="/app/trainings/editE" method="get">
      <div class="row border-bottom border-3 p-1 m-1">
        <div class="col noPadding">
          <h3 class="color-header text-uppercase">Edit training from: ${from}</h3>
        </div>
        <div class="col d-flex justify-content-end mb-2 noPadding">
          <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Edit</button>
        </div>
      </div>

      <div class="schedules-content">

        <div class="form-group row">
          <label for="trainingDate" class="col-sm-2 label-size col-form-label">
            Training Date
          </label>
          <div class="col-sm-10">
            <input class="form-control" value="${training.trainingDay}" id="trainingDate" type="date" name="date">
          </div>
        </div>

        <div class="form-group row">
          <label for="trainingDescription" class="col-sm-2 label-size col-form-label">
            Training Description
          </label>
          <div class="col-sm-10">
                                <textarea class="form-control" rows="5" id="trainingDescription"
                                          value="<c:out value='${training.description}'/>" name="description"></textarea>
          </div>
        </div>

        <div class="col noPadding">
          <h3 class="color-header text-uppercase">Training Details:</h3>
        </div>

        <div class="form-group row">
          <label for="trainingDistance" class="col-sm-2 label-size col-form-label">
            Distance
          </label>
          <div class="col-sm-10">
            <input class="form-control" value="${trainingDetail.kilometers}" id="trainingDistance" type="number" name="kilometers">
          </div>
        </div>

        <div class="form-group row">
          <label for="trainingHours" class="col-sm-2 label-size col-form-label">
            Hours
          </label>
          <div class="col-sm-10">
            <input class="form-control" value="${hours}" id="trainingHours" type="number" name="hours">
          </div>
        </div>
        <div class="form-group row">
          <label for="trainingMinutes" class="col-sm-2 label-size col-form-label">
            Minutes
          </label>
          <div class="col-sm-10">
            <input class="form-control" value="${minutes}" id="trainingMinutes" type="number" name="minutes">
          </div>
        </div>
        <div class="form-group row">
          <label for="trainingSeconds" class="col-sm-2 label-size col-form-label">
            Seconds
          </label>
          <div class="col-sm-10">
            <input class="form-control" value="${seconds}" id="trainingSeconds" type="number" name="seconds">
          </div>
        </div>
        <div class="col noPadding">
          <h3 class="color-header text-uppercase">Your parameters:</h3>
        </div>

        <div class="form-group row">
          <label for="height" class="col-sm-2 label-size col-form-label">
            Height
          </label>
          <div class="col-sm-10">
            <input class="form-control" value="${trainingDetail.height}" id="height" type="number" name="height">
          </div>
        </div>
        <div class="form-group row">
          <label for="weight" class="col-sm-2 label-size col-form-label">
            Weight
          </label>
          <div class="col-sm-10">
            <input class="form-control" value="${trainingDetail.weight}" id="weight" type="number" name="weight">
          </div>
        </div>
      </div>
    </form>
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