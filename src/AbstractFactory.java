
//ပထမဆုံး fmaily of product ဖြစ်တဲ့ abstract class တွေ ဖန်တီးရပါမယ်။
abstract class ReportHeader
{
    abstract void genereateHeader();
}
abstract class ReportBody
{
    abstract void generateBody();
}

//အပေါ်က class 2 ခုက client ကသုံးမဲ့ class တွေပါပဲ။
// Client က အဲ့ဒီ abstract class တွေကိုပဲသုံးတော့ different implementation ကိုနောက်ပိုင်းထပ်ထဲ့ရတာပိုလွယ်မှာပါ။
// ခု သူတို.နဲ.ဆိုင်တဲ့ concrete implementation တွေကို အောက်ပါအတိုင်းရေးပါတယ်။
class HTMLReportHeader extends ReportHeader
{
    @Override    void genereateHeader() {
        System.out.println("HTML report header");
    }
}
class HTMLReportBody extends ReportBody
{
    @Override
    void generateBody() {
        System.out.println("HTML report body");
    }
}

class PDFReportHeader extends ReportHeader
{
    @Override
    void genereateHeader() {
        System.out.println("PDF report header");
    }
}
class PDFReportBody extends ReportBody
{
    @Override
    void generateBody() {
        System.out.println("PDF report body");
    }
}
//HTMLReportHeader,HTMLReportBody, PDFReportHeader,PDFReportBody တွေက
// family of product တွေအတွက် different implementation တွေပါ။ သူတို.အတွက် Factory method တွေဆောက်ပါမယ်။
// ဒါဆို Abstract factory method design pattern ရမှာပါ။
abstract class ReportFactory
{
    abstract ReportHeader createHeader();
    abstract ReportBody createBody();
}
class HTMLReportFactory extends ReportFactory
{
    @Override
    ReportHeader createHeader() {
        return new HTMLReportHeader();
    }
    @Override
    ReportBody createBody() {
        return new HTMLReportBody();
    }
}
class PDFReportFactory extends ReportFactory
{
    @Override
    ReportHeader createHeader() {
        return new PDFReportHeader();
    }
    @Override
    ReportBody createBody() {
        return new PDFReportBody();
    }
}



//အပေါ်က class 3 ခုက abstract factory အတွက်အသက်ပါ။
// ReportFactory သည် abstract factory class ပါသူ.ထဲမှာပါတဲ့ createHeader ရယ် createBody ရယ်က
// abstract class တွေဖြစ်တဲ့ ReportHeader နဲ. ReportBody ကိုပဲ return ပြန်ပါတယ်။
// ဒီ Abstract Factory ကိုသုံးတဲ့ Client က concrete implementation ကိုသိစရာမလိုပဲနဲ.
// ReportHeader နဲ. ReportBody ကိုသိရင်ရပါပြီ ။ ဒီနေရာမှာ ReportFactory ကို extends လုပ်တဲ့
// Concrete Factory class တွေဖြစ်တဲ့ HTMLReportFactory နဲ. PDFReportFactory က concreate class တွေကို
// သူတို. ရဲ. createHeader ,createBody မှာ return ပြန်ပါတယ်။ ဒါပေမဲ့ client က ဘယ် different implementation ကို
// သိစရာမလိုပဲ ReportHeader, ReportBody အနေနဲ.ပဲသုံးရမှာပါ။ အောက် က code က Client code ပါ။


public class AbstractFactory {
    public static void main(String[] args) {
        ReportFactory fac = new HTMLReportFactory();// here create factory
        ReportHeader header = fac.createHeader();
        ReportBody body = fac.createBody();
        header.genereateHeader();
        body.generateBody();
    }
}
