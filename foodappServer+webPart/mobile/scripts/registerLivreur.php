<?php

require'db_con.php';

$Body = file_get_contents('php://input');
$obj = json_decode($Body); 

$nom= $obj->{'nomlivreur'}; 
$prenom= $obj->{'prenomlivreur'}; 
$adresse= $obj->{'adresselivreur'}; 
$email= $obj->{'emaillivreur'}; 
$login= $obj->{'loginlivreur'}; 
$tel= $obj->{'tellivreur'}; 
$mdp= $obj->{'mdplivreur'}; 


$sql="INSERT INTO livreur (adresselivreur,emaillivreur,loginlivreur,mdplivreur,nomlivreur, prenomlivreur, tellivreur) VALUES ('".$adresse."', '".$email."', '".$login."' , '".$mdp."' , '".$nom."', '".$prenom."','".$tel."')";

mysqli_query($link,$sql);
mysqli_close($link);

?>

