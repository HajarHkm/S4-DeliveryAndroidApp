<?php

define ('DB_SERVER','localhost');
define ('DB_USERNAME','root');
define ('DB_PASSWORD','');
define ('DB_NAME','foodapp');

$link= mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_NAME);

if($link === false){
	die("Error connecting". mysqli_connect_error());
}
