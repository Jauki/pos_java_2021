<%@ page contentType="text/html; charset=UTF-16" pageEncoding="UTF-16" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Währungsrechner</title>
    <script src="script.js"></script>
</head>
<body>
<div class="container">
    <h1>Währungsrechner:</h1>
    <div class="card">
        <div class="card-body">
            <form action="waehrungs-rechner" method="post" onsubmit="return onValidate(this);">
                <div class="form-group row">
                    <label class="col-md-4 col-form-label">Betrag</label>
                    <div class="col-md-2">
                        <input name="betrag" id="betrag" placeholder="100.--" class="form-control">
                    </div>
                    <div id="errorValue" style="display: block!important; " class="col-md-3 invalid-feedback"></div>
                </div>

                <div class="form-group row">
                    <label class="col-md-4 col-form-label">Basiswährung</label>
                    <div class="col-md-4">
                        <select name="basis" class="form-control form-control" id="baseLong" onchange="shortSetter('baseLong','baseShort')">
                            <option value="euro">Euro</option>
                            <option selected value="us_dollar">US Dollar</option>
                            <option value="etherum">Etherum</option>
                            <option value="rand">Rand</option>
                            <option value="doge">Doge</option>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <select name="basisShort" class="form-control" id="baseShort" onchange="shortSetter('baseShort','baseLong')">
                            <option value="euro">EUR</option>
                            <option selected value="us_dollar">USD</option>
                            <option value="etherum">ETH</option>
                            <option value="rand">ZAR</option>
                            <option value="doge">DOG</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <input type="button" name="switch" class="btn btn-primary col-md-3 mx-auto" value="🔄" onclick="onSwap()">
                </div>

                <div class="form-group row">
                    <label class="col-md-4 col-form-label">Zielwährung</label>
                    <div class="col-md-4">
                        <select name="ziel" id="resultLong" class="form-control form-control" onchange="shortSetter('resultLong','resultShort')">
                            <option value="euro">Euro</option>
                            <option value="us_dollar">US Dollar</option>
                            <option value="etherum">Etherum</option>
                            <option value="rand">Rand</option>
                            <option value="doge">Doge</option>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <select name="zielShort" id="resultShort" class="form-control" onchange="shortSetter('resultShort','resultLong')">
                            <option value="euro">EUR</option>
                            <option value="us_dollar">USD</option>
                            <option value="etherum">ETH</option>
                            <option value="rand">ZAR</option>
                            <option value="doge">DOG</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <input type="submit" name="calc" value="Neu Berechnen" class="btn btn-primary col-md-3 mx-auto">
                </div>

             </form>
        </div>


    </div>

</div>
</body>
</html>