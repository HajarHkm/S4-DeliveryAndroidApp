<?php

require'db_con.php';

$sql="select * from pub where state='up'";

$results=mysqli_query($link,$sql);
$response=array();

if(mysqli_num_rows($results)>0)
{
	while($row=mysqli_fetch_array($results))
	{
		array_push($response,array('idpub'=> $row['idpub'],'idrestau'=> $row['idrestau'],'path'=> $row['path'])

		);
	}
}
                        
echo json_encode($response);
mysqli_close($link);
?>