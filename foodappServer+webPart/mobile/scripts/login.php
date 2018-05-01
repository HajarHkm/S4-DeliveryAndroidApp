<?php
require'db_con.php';

$log=$_GET['login'];
$mdp=$_GET['mdp'];

$sql_client="select * from client where loginclient='".$log."' and mdpclient='".$mdp."'";
$sql_livreur="select * from livreur where loginlivreur='".$log."' and mdplivreur='".$mdp."'";

$results_client=mysqli_query($link,$sql_client);
$results_livreur=mysqli_query($link,$sql_livreur);

$response;

if(mysqli_num_rows($results_client) > 0)
{
	while($row=mysqli_fetch_array($results_client))
	{
		$response=array('adresseclient'=> $row['adresseclient'],'emailclient'=> $row['emailclient'],'idclient'=>$row['idclient'],'loginclient'=>$row['loginclient'],'mdpclient'=>$row['mdpclient'],
				'nomclient'=>$row['nomclient'],'prenomclient'=>$row['prenomclient'],'telclient'=>$row['telclient']);
	}
}
else if(mysqli_num_rows($results_livreur) > 0)
{
	while($row=mysqli_fetch_array($results_livreur))
	{
		$response=array('adresselivreur'=> $row['adresselivreur'],'emaillivreur'=> $row['emaillivreur'],'idlivreur'=>$row['idlivreur'],'loginlivreur'=>$row['loginlivreur'],'mdplivreur'=>$row['mdplivreur'],
				'nomlivreur'=>$row['nomlivreur'],'prenomlivreur'=>$row['prenomlivreur'],'tellivreur'=>$row['tellivreur']);
	}
}

echo json_encode($response);
mysqli_close($link);
?>
