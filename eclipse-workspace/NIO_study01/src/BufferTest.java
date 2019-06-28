import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class BufferTest {
	public static void main(String[] args) {
		File f = new File("../Net_study03/src/com/hasee/chat01/Chat.java");
		
		try {
			//获取Channel
			FileChannel channel = new FileInputStream(f).getChannel();
			//创建ByteBuffer
			ByteBuffer byteBuffer = ByteBuffer.allocate(100);
			while(channel.read(byteBuffer) != -1) {
				byteBuffer.flip(); //锁定byteBuffer
				Charset charset = Charset.forName("UTF-8");
				CharsetDecoder charsetDecoder = charset.newDecoder();
				CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
				System.out.println(charBuffer);
				byteBuffer.clear(); //将byteBuffer初始化，为下次读取数据做准备
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
