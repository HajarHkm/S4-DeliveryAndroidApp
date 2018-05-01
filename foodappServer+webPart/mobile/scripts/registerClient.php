<?php

require'db_con.php';

$Body = file_get_contents('php://input');
$obj = json_decode($Body); 

$nom= $obj->{'nomclient'}; 
$prenom= $obj->{'prenomclient'}; 
$adresse= $obj->{'adresseclient'}; 
$email= $obj->{'emailclient'}; 
$login= $obj->{'loginclient'}; 
$tel= $obj->{'telclient'}; 
$mdp= $obj->{'mdpclient'}; 


$sql="INSERT INTO client (adresseclient,emailclient,loginclient,mdpclient,nomclient, prenomclient, telclient) VALUES ('".$adresse."', '".$email."', '".$login."' , '".$mdp."' , '".$nom."', '".$prenom."','".$tel."')";

mysqli_query($link,$sql);
mysqli_close($link);

?>