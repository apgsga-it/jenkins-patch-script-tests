#!groovy
library 'patch-global-functions'

properties([
	parameters([
		stringParam(
		defaultValue: "",
		description: 'Path to Patch*.json File',
		name: 'PARAMETER'
		),
		stringParam(
		defaultValue: "FALSE",
		description: 'Indicator, if the Pipeline should be restartet to the last successful state',
		name: 'RESTART'
		)
	])
])

def patchConfig = patchfunctions.readPatchFile(params.PARAMETER)
patchfunctions.initPatchConfig(patchConfig,params)
println "PatchConfig:"
println patchConfig.toString()
//
//// Load Target System Mappings
//def targetSystemsMap = patchfunctions.loadTargetsMap()
//patchfunctions.log("TargetSystemsMap : ${targetSystemsMap} ")
//// Create a local Maven Repo for Pipeline
//patchfunctions.mavenLocalRepo(patchConfig)
//// Retrieve event. State, which will re - done
//patchfunctions.redoToState(patchConfig)
//
//// Mainline
//
//
//// Artefacts are tagged = ready to be built and deployed with start of Patch Pipeline
//def target = targetSystemsMap.get('Entwicklung')
//patchfunctions.stage(target,"Installationsbereit",patchConfig,"Notification", patchfunctions.&notify)
//def phases = targetSystemsMap.keySet()
//phases.removeElement('Entwicklung')
//
//phases.each { envName ->
//	target = targetSystemsMap.get(envName)
//	assert target != null
//	patchfunctions.saveTarget(patchConfig,target)
//
//	// Approve to make Patch "Installationsbereit" for target
//	patchfunctions.stage(target,"Installationsbereit",patchConfig,"Approve", patchfunctions.&approveBuild)
//	patchfunctions.stage(target,"Installationsbereit",patchConfig,"Build", patchfunctions.&patchBuildsConcurrent)
//
//}
//
