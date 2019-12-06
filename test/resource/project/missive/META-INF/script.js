function union(a,b)
{
	return Packages.org.apache.commons.collections.CollectionUtils.union(a,b);
}

function subtract(a,b)
{
	return Packages.org.apache.commons.collections.CollectionUtils.subtract(a,b);
}

function intersection(a,b)
{
	return Packages.org.apache.commons.collections.CollectionUtils.intersection(a,b);
}

function isSubCollection(a,b)
{
	return Packages.org.apache.commons.collections.CollectionUtils.isSubCollection(a,b);
}

function isEqualCollection(a,b)
{
	return Packages.org.apache.commons.collections.CollectionUtils.isEqualCollection(a,b);
}

function containsAny(a,b)
{
	return Packages.org.apache.commons.collections.CollectionUtils.containsAny(a,b);
}

//var allTargets = new Packages.java.util.HashMap();

function getActivityByName(actName)
{
	var activity = null;
	try{
		activity = allTargets.get(actName);
	}catch(e){
		out.println("::::::::::Exception in Mathod : getActivityByName(actName)::::::::::");
	}
	
	return activity;
}

function getActivitiesByNames(actNames)
{
	var activities = new Packages.java.util.ArrayList();
	var names = actNames.split(",");
	for(var i = 0; i < names.length; i++)
	{
		var activity = getActivityByName(names[i]);
		if(activity != null)
		{
			activities.add(activity);
		}
	}
	return activities;
}


function setActivityParticipants(actName, participants)
{
	try{
		var target = allTargets.get(actName);
		if(target != null)
		{
			var parts = target.getParticipants();
			parts.clear();
			if(participants != null)
			{
				parts.addAll(participants);
			}
		}
	}catch(e){
		out.println("::::::::::Exception in Mathod : setActivityParticipants(actName, participants)::::::::::");
	}
}

/*
function initAllActivities()
{
	var it = null;
	try{
		it = targets.iterator();
	}catch(e){
		it = routes.iterator();
	}
	if(it != null){
		while(it.hasNext())
		{
			var activity = it.next();
			allTargets.put(activity.getActivityName(), activity);
			allTargets.put(new Packages.java.lang.Integer(activity.getActivityId()), activity);
		}
	}
}


initAllActivities();
*/