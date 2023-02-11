<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="appheader.jsp" %>

<div class="m-4 p-3 width-medium ">
    <div class="dashboard-content border-dashed p-3 m-4">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">Training details</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <a href="/app/training/list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Back</a>
            </div>
        </div>

        <div class="schedules-content">
            <div class="schedules-content-header">
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Your height until training:
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${trainingDetail.height} cm</p>
                    </div>
                </div>
                <%--                next div--%>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Your weight until training:
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${trainingDetail.weight} kg</p>
                    </div>
                </div>
                <%--                next div--%>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Average temp:
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${trainingDetail.temp} kmh</p>
                    </div>
                </div>
                <%--                next div--%>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Burned kcal:
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${trainingDetail.kcal} kcal</p>
                    </div>
                </div>
                <%--                next div--%>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Distance:
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${trainingDetail.kilometers} km</p>
                    </div>
                </div>
                <%--                next div--%>
            </div>

            </tbody>


        </div>
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