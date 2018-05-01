<?php
require'db_con.php';
$idlivreur=$_GET['idlivreur'];

$sql="select * from commande where etat in ('delivering','delivered') and idlivreur=".$idlivreur;

$results=mysqli_query($link,$sql);
$response=array();

if(mysqli_num_rows($results) > 0)
{
	while($row=mysqli_fetch_array($results))
	{
		array_push($response,array('idcommande'=> $row['idcommande'],'idclient'=> $row['idclient'],'idlivreur'=>$row['idlivreur'],'etat'=>$row['etat'],'datecommande'=>$row['datecommande'],'adresselivraison'=>$row['adresselivraison']
			));
	}
}
echo json_encode($response);
mysqli_close($link);
?>