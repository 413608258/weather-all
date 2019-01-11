<html>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
      integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
      crossorigin="anonymous">
<link href="Content/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="Content/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" />

<script src="Content/jquery-1.9.1.min.js"></script>
<script src="Content/bootstrap/js/bootstrap.min.js"></script>
<script src="Content/bootstrap-select/js/bootstrap-select.min.js"></script>
<script src="Content/bootstrap-select/js/i18n/defaults-zh_CN.min.js"></script>
<title>Lous 的天气预报</title>
<body>
<div class="container">
    <div class="row">
        <h3>${title}</h3>
        <select class="custom-select" id="selectCityId">
            <#list cityList as city>
                <#if city.cityId == cityId>
                    <option value="${city.cityId}" selected>${city.cityName}</option>
                </#if>
                <#if city.cityId != cityId>
                    <option value="${city.cityId}">${city.cityName}</option>
                </#if>
            </#list>
            <#--<option th:each="city : ${cityList}"
                    th:value="${city.cityId}" th:text="${city.cityName}"
                    th:selected="false">
            </option>-->
        </select>
    </div>
    <div class="row">
        <h1 class="text-success" th:text="">${report.city}</h1>
    </div>
    <#--<div class="row">
        <p>
            空气质量指数：<span th:text="${reportModel.report.aqi}"></span>
        </p>
    </div>-->
    <div class="row">
        <p>
            当前温度：<span>${report.wendu}℃</span>
        </p>
    </div>
    <div class="row">
        <p>
            温馨提示：<span>${report.ganmao}</span>
        </p>
    </div>
    <div class="row">
        <#list report.forecast as forecast>
            <div class="card-body text-info">
                <p class ="card-text" th:text="">${forecast.date}</p>
                <p class ="card-text" th:text="">${forecast.type}</p>
                <p class ="card-text" th:text="">${forecast.high}</p>
                <p class ="card-text" th:text="">${forecast.low}</p>
                <p class ="card-text" th:text="">${forecast.fengxiang}</p>
            </div>
        </#list>
    </div>
</div>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
    <!-- Optional JavaScript -->
    <script type="text/javascript" th:src="@{/js/weather/report.js}"></script>
</body>
</html>