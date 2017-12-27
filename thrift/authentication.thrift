include "exceptions.thrift"


namespace java com.pangramia.services.authentication


service MyAuthService {
    string authenticate( 1:string user, 2:string password )
        throws ( 1:exceptions.PBUserException e )

    string mymethod( 1:string authstring, 2:string otherargs)
        throws ( 1:exceptions.PBUserException e)
}