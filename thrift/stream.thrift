namespace java com.pangramia.services.streaam

service StreamService {
	list<i64> getCameras (1: i64 streamId)
	string getCamera (1: i64 streamId, 2: cameraId)
}
