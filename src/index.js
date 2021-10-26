var path = require('path');
var fs = require('fs');
var ejs = require('ejs');
var data=require("./data.js")



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
}

data.package_path=data.packageName.replace(/\./g,"/")
data.package_name=data.packageName
data.module_name=data.moduleName
data.filename=data.moduleName[0].toUpperCase() + data.moduleName.slice(1);
data.system_package="com.dj.codeg"
data.display_name=data.moduleDisplayName,
data.request_path_prefix=data.urlprefix,
data.name=data.moduleName,
basedirs.forEach(e => {
    console.log(e.target);
    cg(e.source,e.target,data);
});

