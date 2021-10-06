
## 任务一
代码理解：

代码有两部分，一是将排序算法编码到选择的图片中，二是将图片解码出排序算法供W02的老人使用。
1. SteganographyFactory进行编码（隐写术）。先是对.java文件进行编译，生成二进制文件.class文件（目录可见）。然后用ImageIO读取图片并生成相应的SteganographyEncoder。再传入前面生成的类，将二进制码转化成数组bytes。通过getRGB()获得图片的像素数组pixels，进行图片掩码处理，将.class文件编码进了图片。
2. 解码时先定义了自己的类加载器SteganographyClassLoader，然后加载相应类。类加载器会先向上委派，而父类加载器无法加载时又会向下委派，最终进入了自己定义的findClass方法，把图片进行解码后生成了.class文件。然后用newInstance方法生成排序器。

## 任务二

1. example.QuickSorter.png:https://i.loli.net/2021/10/06/ZuycflqXD79tszF.png
2. example.ShellSorter.png:https://i.loli.net/2021/10/06/TdKzUcQhOr94FGR.png


## 任务三

B站视频：https://www.bilibili.com/video/BV1sv411g7TE?spm_id_from=333.999.0.0

## 任务四

使用群友202220008刘睿哲同学的堆排序照片，结果相同