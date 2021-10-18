<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
    <title>Schülerliste</title>
    <script src="script.js"></script>
</head>
<body>
<form action="StudentController" method="get">
    <div class="p-8 w-max mx-auto">
        <div class="rounded-xl shadow-md w-full flex flex-col p-3">
            <div class="bg-white flex flex-row items-center">
                <input class="rounded-l-full flex-w-40 py-4 px-6 text-gray-700 leading-tight focus:outline-none" name="filter" id="search" type="text" placeholder="Search" onkeyup="filterMethode()">
                <div class="p-4 flex-end">
                    <button class="bg-green-600 text-white rounded-full p-2 hover:bg-green-700 focus:outline-none w-12 h-12 flex items-center justify-center">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
                <select id="secletor" class="p-3 rounded-md shadow-md w-full" onchange="detail(this)">
                </select>

        </div>
    </div>
    </div>
</form>


<div class="p-8 w-2/6 mx-auto" id="detail" style="display: none">
    <div class="shadow-xl rounded-lg">
        <div class="h-44 bg-green-600 bg-cover bg-center rounded-t-lg flex items-center justify-center">
        </div>
        <div class="bg-white rounded-lg px-8 mx-auto">
            <div class="mx-auto pt-8">
                <img class="-mt-28 w-32 h-32 mx-auto rounded-full shadow-lg" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png">
            </div>

            <div class="pt-8 pb-8 text-center">
                <h1 class="text-2xl font-bold text-gray-700" id="name">NAME</h1>
                <div class="text-sm text-gray-600" id="class">X</div>
                <div class="text-sm text-gray-600" id="age">X</div>
                <div class="text-sm text-gray-600" id="catNo">X</div>
                <div class="text-sm text-gray-600" id="birthDate">X</div>

            </div>
        </div>
    </div>
</div>
</body>
</html>