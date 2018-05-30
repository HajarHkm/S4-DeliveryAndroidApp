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
$idlivreur = $obj->{'idlivreur'}; 


$sql="UPDATE  livreur adresselivreur='".$adresse."',emaillivreur='".$email."',loginlivreur = '".$login."' ,mdplivreur = '".$mdp."' ,nomlivreur = '".$nom."', prenomlivreur = '".$prenom."', tellivreur = '".$tel."'  where idlivreur = '".$idlivreur."' ";

mysqli_query($link,$sql);
mysqli_close($link);

?>
