var path = require('path');
var fs = require('fs');
var ejs = require('ejs');

opts = {
    "module_name": "cgtest",
    "filename": "Cgtest",
    "name": "cgtest",
    "display_name": "测试模块",
    "package_name": "com.dj.codeg.m",
    "package_path": "com/dj/codeg/m",
    "entity":"test.entity",
    "system_package":"com.dj.codeg",
    "request_path_prefix":"/"
}

basedirs =   [
     {
    "source":"./seed/springboot/cg",
    "target":"./seed/springboot/src/main/java"
    },
    {
    "source":"./seed/vue/cg",
    "target":"./seed/vue/src/m",
    }
]

var cg=(basedir, distdir, param)=>{

    fs.readdir(basedir,(err,files)=>{
        if(err){
            console.log("err")
        }else{
            files.forEach(file => {
                if(fs.statSync(`${basedir}/${file}`).isDirectory()){
                    cg(`${basedir}/${file}`,`${distdir}/${file}`,param)
                }else{     
                    var targetDir=  distdir+"/"+file;             
                    for (const key  in param) {
                        var r='\\${'+key+'}';
                        targetDir=  targetDir.replace( new RegExp(r,"g"), param[key])
                    }
                    var fileExists =fs.existsSync(targetDir,()=>{})
                    if(!fileExists){
                        var t=targetDir.split("/");
                        var p=t.slice(0,t.length-1).join("/");
                        fs.mkdirSync(p,{recursive:true},(err)=>{
                            if(err){
                                console.log(err);
                            }
                        })
                    }
                  


                    var file=`${basedir}/${file}`;
              
                    fs.readFile(file, 'utf8', function(err, data){
                        var tempData=data;
                        for (const key  in param) {
                            var r='\\${'+key+'}';
                            tempData=tempData.replace(new RegExp(r,"g"), param[key])
                        }

                        console.log("[C]"+targetDir);
                        fs.writeFile(targetDir,tempData,(e)=>{
                                if(e){
                                    console.log("写入文件失败")
                                }
                        });
                    });
                }
            })
        }
    });
    // for entry in os.scandir(basedir):
    //     if entry.is_dir():
    //         cg(basedir + "/" + entry.name, distdir + "/" + entry.name,param);
    //     else:
    //         path_template = Template(distdir)
    //         pathname = path_template.substitute(param)
    //         os.makedirs(pathname,exist_ok=True);
    //         filename_template = Template(distdir + "/" + entry.name)
    //         filename = filename_template.substitute(param)
    //         #print("filename"+filename);
    //         f = open(basedir + "./" + entry.name, encoding='utf8')
    //         file_template = Template(f.read())
    //         filecontent = file_template.substitute(param)
    //         print("create:" + filename);
    //         # print(filecontent);
    //         distfile = open(filename, "w", encoding='utf8')
    //         distfile.write(filecontent)
    //         distfile.close()
}

basedirs.forEach(e => {
    console.log(e.target);
    cg(e.source,e.target,opts);
});

