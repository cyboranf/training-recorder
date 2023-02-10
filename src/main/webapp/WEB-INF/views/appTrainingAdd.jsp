<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="appheader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="m-4 p-3 width-medium text-color-darker">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">

        <form action="/app/trainings/add" method="post">
            <div class="mt-4 ml-4 mr-4">
                <div class="row border-bottom border-3">
                    <div class="col"><h3 class="color-header text-uppercase">New training</h3></div>
                    <div class="col d-flex justify-content-end mb-2">
                        <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Save training</button>
                    </div>
                </div>
                <table class="table borderless">
                    <tbody>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Training date</th>
                        <td class="col-7">
                            <input name="date" type="date" class="w-100 p-1" value="">
                        </td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Training description</th>
                        <td class="col-7"><textarea class="w-100 p-1" rows="5" name="description"></textarea></td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Distance</th>
                        <td class="col-3">
                            <input class="p-1" type="number" value="" name="kilometers">
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="row d-flex">
                    <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Your parameters
                    </h3></div>
                    <div class="col-2"></div>
                    <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Time</h3></div>
                </div>
                <div class="row d-flex">
                    <div class="col-5 p-4">
                        <th scope="row" class="col-2">Weight</th>
                        </br>
                        <input class="w-100 p-1" rows="5" type="number" value="" name="weight">
                        <th scope="row" class="col-2">Height</th>
                        </br>
                        <input class="w-100 p-1" rows="5" type="number" value="" name="height">
                        <%--            <textarea class="w-100 p-1" rows="5" name="preparation"></textarea>--%>
                    </div>
                    <div class="col-2"></div>

                    <div class="col-5 p-4">
                        <th scope="row" class="col-2">Hours</th>
                        </br>
                        <input name="hours" type="number" class="w-100 p-1" value="">
                        <th scope="row" class="col-2">Minutes</th>
                        </br>
                        <input name="minutes" type="number" class="w-100 p-1" value="">
                        <th scope="row" class="col-2">Seconds</th>
                        </br>
                        <input name="seconds" type="number" class="w-100 p-1" value="">

                    </div>
                </div>
            </div>
        </form>

</div>
</div>



