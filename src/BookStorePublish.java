import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace = "http://custom.booklist/")
@SOAPBinding( style = SOAPBinding.Style.DOCUMENT )

public class BookStorePublish {

    private BookStore bs;
    public BookStorePublish() {
        super();
        bs = new BookStore();
        bs.setStoreName("Waterstones");
        bs.setStoreLocation("Swansea High Street");
    }


    @WebMethod
    public BookStore getBookStore()
    {
        return bs;

        /*<soapenv:Envelope xmlns:mns="http://custom.booklist/" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
            <soapenv:Body>
                <mns:getBookStore> </mns:getBookStore>
            </soapenv:Body>
         </soapenv:Envelope>
         */
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9876/bookstores", new BookStorePublish());

    }

}